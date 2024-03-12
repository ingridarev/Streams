package org.academy2024.lab3;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_3_1_printTopTransactions();
    }

    private void exercise_3_1_printTopTransactions() {

        List<Transaction> transactions = DataHelper.loadTransactions();
        int howManyBiggestAmounts = 3;
        int count = 0;

        List<Transaction> topList =
                transactions.stream()
                        .sorted(Comparator.comparing(Transaction::amount).reversed())
                        .limit(howManyBiggestAmounts)
                        .toList();

        topList.stream().forEach(System.out::println);
        LinePrinter.resetColor();

        Set<Transaction> transactionSet = new TreeSet<>(Comparator.comparing(Transaction::amount).reversed());
        transactionSet.addAll(transactions);

        for (Transaction trans : transactionSet) {
            if (count < howManyBiggestAmounts) {
                LinePrinter.print(Color.RED, trans.toString());
            } else {
                LinePrinter.print(Color.GREEN, trans.toString());
            }
            count++;
        }

        LinePrinter.resetColor();
    }
}
