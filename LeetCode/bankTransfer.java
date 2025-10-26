class Bank {

    private Map<Integer, Long> accounts;

    public Bank(long[] balance) {
        accounts = new HashMap<>();
        for (int i = 0; i < balance.length; i++) {
            accounts.put(i + 1, balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 0 || account1 > accounts.size()) { 
            return false;
        }
        if (account2 < 0 || account2 > accounts.size()) { 
            return false;
        }
        long moneyOfAccount1 = accounts.get(account1);
        if (moneyOfAccount1 < money) { 
            return false;
        }
        accounts.put(account1, accounts.get(account1) - money);
        accounts.put(account2, accounts.get(account2) + money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (account < 0 || account > accounts.size()) { 
            return false;
        }
        accounts.put(account, accounts.get(account) + money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (account < 0 || account > accounts.size()) { 
            return false;
        }
        long moneyOfAccount = accounts.get(account); 
        if (moneyOfAccount < money) { 
            return false;
        }
        accounts.put(account, accounts.get(account) - money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
