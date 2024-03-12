package org.academy2024.lab1;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_1_1_simplyPrintTransactions();
        lab.exercise_1_2_printTransactionsSorted();
    }

    private void exercise_1_1_simplyPrintTransactions() {

        transactions.forEach(t -> LinePrinter.print(Color.GREEN, t.toString()));
        LinePrinter.resetColor();
    }

    private void exercise_1_2_printTransactionsSorted() {

        Collections.sort(transactions, Comparator.comparing(Transaction::date)
                .thenComparing(Transaction::amount));


        transactions.forEach(t -> LinePrinter.print(Color.GREEN, t.toString()));
        LinePrinter.resetColor();
    }
}
