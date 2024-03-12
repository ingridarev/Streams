package org.academy2024.lab4;

import org.academy2024.AccountHolder;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.lab4_1_namesOfAccountHolders();
    }

    private void lab4_1_namesOfAccountHolders() {

        List<Transaction> transactions = DataHelper.loadTransactions();
        List<AccountHolder> accountHolders = DataHelper.loadAccountHolders();


        Map<String, AccountHolder> accountHolderMap = new HashMap<>();
        for (AccountHolder holder : accountHolders) {
            accountHolderMap.put(holder.accountId(), holder);
        }

        List<StatementLine> statementLineList = transactions.stream()
                .map(t ->
                        new StatementLine(
                                accountHolderMap.get(t.accountId()).name(),
                                t.accountId(),
                                t.date(),
                                t.amount()))
                .toList();
        LinePrinter.resetColor();

        for (StatementLine line : statementLineList) {
            LinePrinter.print(line.toString());
        }
    }

    void intoMap(Map<String, AccountHolder> m, AccountHolder a) {
        m.put(a.accountId(), a);
    }

}
