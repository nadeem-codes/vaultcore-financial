const BASE_URL = "http://localhost:8081/api";

// Utility function to show response
function show(data) {
  const output = document.getElementById("output");
  if (output) {
    output.innerText = typeof data === "string"
      ? data
      : JSON.stringify(data, null, 2);
  }
}

// Safe fetch helper (prevents JSON crash)
async function safeFetch(url, options = {}) {
  try {
    const res = await fetch(url, options);
    const text = await res.text();

    try {
      return JSON.parse(text);
    } catch {
      return text;
    }
  } catch (err) {
    return "Error: " + err.message;
  }
}

// =====================
// Create User
// =====================
async function createUser() {
  const username = document.getElementById("username").value;

  const data = await safeFetch(`${BASE_URL}/users`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name: username })
  });

  show(data);
}

// =====================
// Create Account
// =====================
async function createAccount() {
  const userId = document.getElementById("userId").value;

  const data = await safeFetch(`${BASE_URL}/accounts`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ userId })
  });

  show(data);
}

// =====================
// Get Balance
// =====================
async function getBalance() {
  const id = document.getElementById("accountId").value;

  const data = await safeFetch(`${BASE_URL}/accounts/${id}/balance`);
  show(data);
}

// =====================
// Transfer Money
// =====================
async function transfer() {
  const fromId = document.getElementById("fromId").value;
  const toId = document.getElementById("toId").value;
  const amount = document.getElementById("amount").value;

  const data = await safeFetch(`${BASE_URL}/transactions/transfer`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      fromAccountId: fromId,
      toAccountId: toId,
      amount: amount
    })
  });

  show(data);
}

// =====================
// Buy Stock
// =====================
async function buyStock() {
  const stockName = document.getElementById("stockName").value;
  const qty = document.getElementById("qty").value;

  const data = await safeFetch(`${BASE_URL}/stocks/buy`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      stockName: stockName,
      quantity: qty
    })
  });

  show(data);
}

// =====================
// Sell Stock
// =====================
async function sellStock() {
  const stockName = document.getElementById("sellStockName").value;
  const qty = document.getElementById("sellQty").value;

  const data = await safeFetch(`${BASE_URL}/stocks/sell`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      stockName: stockName,
      quantity: qty
    })
  });

  show(data);
}

// =====================
// Transaction History
// =====================
async function getHistory() {
  const id = document.getElementById("historyAccountId").value;

  const data = await safeFetch(`${BASE_URL}/transactions/${id}`);
  show(data);
}

// =====================
// Freeze Account
// =====================
async function freezeAccount() {
  const id = document.getElementById("freezeAccountId").value;

  const data = await safeFetch(`${BASE_URL}/accounts/${id}/freeze`, {
    method: "PUT"
  });

  show(data);
}