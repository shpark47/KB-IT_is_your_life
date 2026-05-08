<script setup>
import { onMounted, computed } from 'vue';
import { GChart } from 'vue-google-charts';
import { useTransactionStore } from '../stores/transaction';
import StatCard from '../components/StatCard.vue';

const store = useTransactionStore();

onMounted(() => {
  if (store.transactions.length === 0) store.fetchAll();
});

const fmt = (n) => '₩' + n.toLocaleString();

// Pie chart: 카테고리별 지출
const pieData = computed(() => {
  const rows = [['카테고리', '금액']];
  Object.entries(store.expenseByCategory).forEach(([k, v]) => rows.push([k, v]));
  return rows;
});
const pieOptions = {
  title: '카테고리별 지출',
  pieHole: 0.4,
  chartArea: { width: '90%', height: '80%' },
  legend: { position: 'right' },
};

// Bar/Line chart: 월별 수입/지출
const barData = computed(() => {
  const rows = [['월', '수입', '지출']];
  Object.entries(store.monthlyStats)
    .sort(([a], [b]) => a.localeCompare(b))
    .forEach(([m, v]) => rows.push([m, v.income, v.expense]));
  return rows;
});
const barOptions = {
  title: '월별 수입 / 지출',
  chartArea: { width: '80%', height: '70%' },
  colors: ['#28a745', '#dc3545'],
  legend: { position: 'top' },
  vAxis: { format: 'short' },
};

// Line chart: 잔액 추이
const lineData = computed(() => {
  const rows = [['월', '순수익']];
  Object.entries(store.monthlyStats)
    .sort(([a], [b]) => a.localeCompare(b))
    .forEach(([m, v]) => rows.push([m, v.income - v.expense]));
  return rows;
});
const lineOptions = {
  title: '월별 순수익 추이',
  curveType: 'function',
  legend: { position: 'bottom' },
  colors: ['#0d6efd'],
};
</script>

<template>
  <div>
    <div class="d-flex justify-content-between align-items-center mb-4">
      <h2 class="mb-0"><i class="fas fa-chart-line text-primary me-2"></i>대시보드</h2>
      <button class="btn btn-outline-primary btn-sm" @click="store.fetchAll()">
        <i class="fas fa-sync-alt me-1"></i> 새로고침
      </button>
    </div>

    <div v-if="store.loading" class="text-center py-5">
      <div class="spinner-border text-primary"></div>
    </div>

    <div v-else-if="store.error" class="alert alert-danger">
      <i class="fas fa-exclamation-triangle me-2"></i>
      json-server 연결 실패: {{ store.error }} <br />
      <small>터미널에서 <code>npm run server</code> 실행 중인지 확인해주세요 (포트 3001).</small>
    </div>

    <template v-else>
      <!-- 통계 카드 -->
      <div class="row g-3 mb-4">
        <div class="col-md-3 col-sm-6">
          <StatCard title="총 수입" :value="fmt(store.totalIncome)" icon="fas fa-arrow-up" variant="income" />
        </div>
        <div class="col-md-3 col-sm-6">
          <StatCard title="총 지출" :value="fmt(store.totalExpense)" icon="fas fa-arrow-down" variant="expense" />
        </div>
        <div class="col-md-3 col-sm-6">
          <StatCard title="잔액" :value="fmt(store.balance)" icon="fas fa-coins" variant="balance" />
        </div>
        <div class="col-md-3 col-sm-6">
          <StatCard title="거래 건수" :value="store.transactions.length + '건'" icon="fas fa-receipt" variant="count" />
        </div>
      </div>

      <!-- 차트 -->
      <div class="row g-3 mb-4">
        <div class="col-lg-6">
          <div class="card chart-card">
            <div class="card-body">
              <GChart type="PieChart" :data="pieData" :options="pieOptions" :settings="{ packages: ['corechart'] }" style="height: 350px" />
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="card chart-card">
            <div class="card-body">
              <GChart type="ColumnChart" :data="barData" :options="barOptions" :settings="{ packages: ['corechart'] }" style="height: 350px" />
            </div>
          </div>
        </div>
        <div class="col-12">
          <div class="card chart-card">
            <div class="card-body">
              <GChart type="LineChart" :data="lineData" :options="lineOptions" :settings="{ packages: ['corechart'] }" style="height: 300px" />
            </div>
          </div>
        </div>
      </div>

      <!-- 최근 거래 -->
      <div class="card chart-card">
        <div class="card-body">
          <h5 class="mb-3"><i class="fas fa-clock text-secondary me-2"></i>최근 거래</h5>
          <table class="table table-hover align-middle">
            <thead class="table-light">
              <tr>
                <th>날짜</th><th>유형</th><th>카테고리</th><th>메모</th><th class="text-end">금액</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="t in store.recent" :key="t.id">
                <td>{{ t.date }}</td>
                <td>
                  <span :class="t.type === 'income' ? 'badge bg-success' : 'badge bg-danger'">
                    {{ t.type === 'income' ? '수입' : '지출' }}
                  </span>
                </td>
                <td>{{ t.category }}</td>
                <td class="text-muted">{{ t.memo }}</td>
                <td class="text-end" :class="t.type === 'income' ? 'text-income' : 'text-expense'">
                  {{ t.type === 'income' ? '+' : '-' }}{{ fmt(t.amount) }}
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </template>
  </div>
</template>
