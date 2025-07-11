# ATMInterface
# 🏧 Java ATM Interface – Console Based Banking System

A **fully functional ATM system** built using Java (console-based) that simulates real-world banking operations like balance inquiry, withdrawals, deposits, mini statements, fund transfers, and more.

## ✅ Features

- 🔐 User Authentication (User ID & PIN)
- 💰 Check Account Balance
- 💵 Deposit Money
- 🏧 Withdraw Money
- 📃 View Transaction History
- 🧾 Mini Statement (Last 5 Transactions)
- 🔄 Transfer Funds between dummy accounts
- 🔑 Change PIN
- 🧹 Clear Transaction History
- 🔁 Menu-driven Interface with input validation

## 🛠 Technologies Used

- Java (JDK 8+)
- Object-Oriented Programming
- Command-Line Interface (CLI)

## 🖥 Demo Output

```
===== Welcome to Enhanced ATM Interface =====
Enter User ID: user123
Enter PIN: 1234
Login successful!

=== ATM Menu ===
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. View Transaction History
5. Mini Statement
6. Transfer Funds
7. Change PIN
8. Clear Transaction History
9. Exit
```

## 📂 Project Structure

```
java-atm-interface/
├── ATM.java               # Contains ATM logic (withdraw, deposit, etc.)
├── ATMInterface.java      # Main program (UI, menu, login, etc.)
├── README.md              # GitHub description of the project
└── .gitignore             # Optional: Java ignores like *.class files
```

## 🚀 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/java-atm-interface.git
   ```

2. Compile the code:
   ```bash
   javac ATMInterface.java
   ```

3. Run the program:
   ```bash
   java ATMInterface
   ```

> ✅ Default credentials:
> - **User ID:** `user123`
> - **PIN:** `1234`

## 📌 Future Enhancements (Optional)
- ✅ GUI using Java Swing or JavaFX
- 💾 File-based or MySQL storage
- 👥 Multiple user accounts
- 🌐 Web version using Java + Spring Boot

## 📄 License

This project is licensed under the **MIT License**. Feel free to use, modify, and distribute.
