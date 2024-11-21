package miniproject_bank2;

import miniproject_bank2.Enum.TransactionStatus;
import miniproject_bank2.Enum.TransactionType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Transaction {
  // 은행별 입출금내역: 시퀀스 넘버 + 입출금 내역 객체
  public static Map<Long, Transaction> transactionMap = new HashMap<>();

  long seqNo;        		    // 거래 고유 번호
  TransactionType type; 	  // 거래 타입 구분 코드
  TransactionStatus status; // 처리 상태
  LocalDate date; 		      // 거래 일시0
  long money; 			        // 금액
  Customer customer;        // 고객
  Banker banker; 	          // 직원 번호

  public Transaction(TransactionType type,
                     TransactionStatus status,
                     long money,
                     Customer customer,
                     Banker banker) {
    this.seqNo = transactionMap.size() + 1;
    this.type = type;
    this.status = status;
    this.date = LocalDate.now();
    this.money = money;
    this.customer = customer;
    this.banker = banker;
  }

  public static void update(Transaction transaction) {
    Transaction.transactionMap.put(transaction.seqNo, transaction);
    System.out.println(Transaction.transactionMap.get(transaction.seqNo).toString());
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "seqNo=" + seqNo +
        ", type=" + type +
        ", status=" + status +
        ", date=" + date +
        ", money=" + money +
        ", customer=" + customer +
        ", banker=" + banker +
        '}';
  }
}


