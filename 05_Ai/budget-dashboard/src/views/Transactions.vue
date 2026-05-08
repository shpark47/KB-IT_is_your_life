<script setup>
import { onMounted, ref, computed } from 'vue';
import { useTransactionStore } from '../stores/transaction';

const store = useTransactionStore();
const filterType = ref('all');
const search = ref('');

onMounted(() => {
  if (store.transactions.length === 0) store.fetchAll();
});

const fmt = (n) => '₩' + n.toLocaleString();

const filtered = computed(() => {
  return store.transactions
    .filter((t) => filterType.value === 'all' || t.type === filterType.value)
    .filter(
      (t) =>
        !search.value ||
        t.category.includes(search.value) ||
        (t.memo || '').includes(search.value)
    )
    .sort((a, b) => b.date.localeCompare(a.date));
});

const remove = async (id) => {
  if (confirm('삭제하시겠습니까?')) await store.deleteTransaction(id);
};
</script>

<template>
  <div>
    <h2 class="mb-4"><i class="fas fa-list text-primary me-2"></i>거래 내역</h2>

    <div class="card chart-card mb-3">
      <div class="card-body">
        <div class="row g-2">
          <div class="col-md-4">
            <select v-model="filterType" class="form-select">
              <option value="all">전체</option>
              <option value="income">수입</option>
              <option value="expense">지출</option>
            </select>
          </div>
          <div class="col-md-8">
            <div class="input-group">
              <span class="input-group-text"><i class="fas fa-search"></i></span>
              <input v-model="search" type="text" class="form-control" placeholder="카테고리 또는 메모 검색" />
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="card chart-card">
      <div class="card-body">
        <p class="text-muted mb-2">총 {{ filtered.length }}건</p>
        <table class="table table-hover align-middle">
          <thead class="table-light">
            <tr>
              <th>날짜</th><th>유형</th><th>카테고리</th><th>메모</th>
              <th class="text-end">금액</th><th class="text-end">관리</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="t in filtered" :key="t.id">
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
              <td class="text-end">
                <button class="btn btn-sm btn-outline-danger" @click="remove(t.id)">
                  <i class="fas fa-trash"></i>
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>
