// Pinia store: axios로 json-server 연결
import { defineStore } from 'pinia';
import { ref, computed } from 'vue';
import axios from 'axios';

// json-server base URL
const API_BASE = 'http://localhost:3001';
const api = axios.create({
  baseURL: API_BASE,
  timeout: 5000,
});

export const useTransactionStore = defineStore('transaction', () => {
  // state
  const transactions = ref([]);
  const loading = ref(false);
  const error = ref(null);

  // === axios로 json-server CRUD ===
  const fetchAll = async () => {
    loading.value = true;
    error.value = null;
    try {
      const res = await api.get('/transactions');
      transactions.value = res.data;
    } catch (e) {
      error.value = e.message;
      console.error('fetchAll error:', e);
    } finally {
      loading.value = false;
    }
  };

  const addTransaction = async (tx) => {
    const res = await api.post('/transactions', tx);
    transactions.value.push(res.data);
  };

  const updateTransaction = async (id, tx) => {
    const res = await api.put(`/transactions/${id}`, tx);
    const idx = transactions.value.findIndex((t) => t.id === id);
    if (idx !== -1) transactions.value[idx] = res.data;
  };

  const deleteTransaction = async (id) => {
    await api.delete(`/transactions/${id}`);
    transactions.value = transactions.value.filter((t) => t.id !== id);
  };

  // === computed (대시보드 통계) ===
  const totalIncome = computed(() =>
    transactions.value
      .filter((t) => t.type === 'income')
      .reduce((s, t) => s + t.amount, 0)
  );

  const totalExpense = computed(() =>
    transactions.value
      .filter((t) => t.type === 'expense')
      .reduce((s, t) => s + t.amount, 0)
  );

  const balance = computed(() => totalIncome.value - totalExpense.value);

  const expenseByCategory = computed(() => {
    const map = {};
    transactions.value
      .filter((t) => t.type === 'expense')
      .forEach((t) => {
        map[t.category] = (map[t.category] || 0) + t.amount;
      });
    return map;
  });

  const monthlyStats = computed(() => {
    const map = {};
    transactions.value.forEach((t) => {
      const month = t.date.slice(0, 7); // YYYY-MM
      if (!map[month]) map[month] = { income: 0, expense: 0 };
      map[month][t.type] += t.amount;
    });
    return map;
  });

  const recent = computed(() =>
    [...transactions.value]
      .sort((a, b) => b.date.localeCompare(a.date))
      .slice(0, 5)
  );

  return {
    transactions,
    loading,
    error,
    fetchAll,
    addTransaction,
    updateTransaction,
    deleteTransaction,
    totalIncome,
    totalExpense,
    balance,
    expenseByCategory,
    monthlyStats,
    recent,
  };
});
