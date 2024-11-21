package miniproject_bank2;

import miniproject_bank2.Enum.BankCode;

import java.util.HashMap;
import java.util.Map;

public class Banker {
  // 은행원: 직원 번호 + 은행원 객체
  public Map<String, Banker> bankerMap = new HashMap<>();
  
  BankCode bankCode;     	// 은행코드
  String bankerNumber;	// 직원번호
  String bankerName;  	// 직원명

  public Banker(BankCode bankCode, String bankerNumber, String bankerName) {
    this.bankCode = bankCode;
    this.bankerNumber = bankerNumber;
    this.bankerName = bankerName;
  }
}

// 은행원의 crud 는 생략