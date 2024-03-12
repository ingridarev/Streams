package org.academy2024.lab2;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_2_1_printTransactionsWithAmountGreaterThan5000();
        lab.exercise_2_2_convertToStatementLinesAndColorize();
    }

    private void exercise_2_1_printTransactionsWithAmountGreaterThan5000() {
        transactions.stream().filter(transaction -> transaction.amount().compareTo(BigDecimal.valueOf(5000)) > 0)
                .forEach(System.out::println);
        LinePrinter.resetColor();
    }

    private void exercise_2_2_convertToStatementLinesAndColorize() {
        transactions.stream().map(transaction -> new StatementLine(transaction.amount().compareTo(BigDecimal.valueOf(5000)) > 0 ?
                        Color.RED : Color.GREEN, transaction.accountId(), transaction.date(), transaction.amount()))
                .forEach(statementLine -> LinePrinter.print(statementLine.color(), statementLine.toString()));
        LinePrinter.resetColor();
    }

    private StatementLine transactionToStatementLine(Color color, Transaction transaction) {
        return new StatementLine(color, transaction.accountId(), transaction.date(), transaction.amount());
    }
}
