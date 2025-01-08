package chapter03;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class D_Package3 {

	public static void main(String[] args) {

		// *Date 클래스 : 날짜를 다루는 클래스
		// Date 클래스의 대부분의 메서드가 Java 1.1부터 사용하지 않도록 권장
		// Date 클래스가 날짜의 데이터 타입으로 자주 사용됨 (날짜를 저장하는 목적의 데이터 타입 but, 실제 날짜를 관리할땐 문자열이 편함)
		Date dateNow = new Date();
		System.out.println(dateNow);
		System.out.println(dateNow.getDate());
		
		// *LocalDateTime 클래스 : Java 8부터 Date 클래스를 대체하기 위해 사용되는 클래스
		// LocalDate 클래스, LocalTime 클래스, LocalDateTime 클래스
		
		// 현재 날짜 및 시간의 인스턴스 생성
		LocalDateTime now = LocalDateTime.now(); // static 메서드라서 new 생성자 사용 X
		LocalDate nowDate = LocalDate.now(); // 연월일
		LocalTime nowTime = LocalTime.now(); // 시분초
		System.out.println(now);
		System.out.println(nowDate);
		System.out.println(nowTime);
		
		// 특정 날짜 및 시간의 인스턴스 생성
		LocalDateTime date1 = LocalDateTime.of(2025, 1, 6, 0, 0, 0);
		System.out.println(date1);
		
		// 특정 날짜 및 시간의 요소 불러오기
		// .getXXX()
		int month = now.getMonthValue();
		System.out.println(month);
		int day = now.getDayOfMonth();
		System.out.println(day);
		
		// 특정 날짜 및 시간의 요소 변경
		// .withXXX()
		// 인스턴스가 직접 변경되는 것이 아니고 변경된 인스턴스를 생성해서 반환, 연결작업 가능
		now = now.withYear(2020).withHour(1);
		System.out.println(now);
		
		// 날짜 및 시간 계산하기
		// .plusXXX(), .minusXXX()
		// 인스턴스가 직접 변경되지 않고 변경된 인스턴스를 생성하여 반환, 연결작업 가능
		now = now.plusHours(18).minusMinutes(20);
		System.out.println(now);
		
		// LocalDateTime 을 Date 로 변경(형변환)
		// Date 클래스의 from 메서드와 LocalDateTime 인스턴스의 toInstant 메서드를 활용
		Date localToDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(localToDate);
		
		// Date 를 LocalDateTime 으로 변경(형변환)
		// Date 인스턴스의 toInstant, toLocalDateTime 메서드 사용
		LocalDateTime dateToLocal = dateNow.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(dateToLocal);
		
		// Date 를 String 으로 변경
		// SimpleDateFormat 클래스를 사용하여 지정한 문자열 포멧으로 변경 가능
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		String stringDate = simpleDateFormat.format(localToDate);
		System.out.println(stringDate);
		// y: 연도, M: 월, d: 일, a: 오전오후, H: 시간(24시간 기준), h: 시간(12시간 기준), m: 분, s: 초, E: 요일
		// 오후 5:14 2025-01-06 <- 이렇게 만들기
		simpleDateFormat = new SimpleDateFormat("a hh:mm yyyy-MM-dd");
		stringDate = simpleDateFormat.format(new Date());
		System.out.println(stringDate);
		
		// LocalDateTime 을 String 으로 변경
		// DateTimeFormatter 클래스를 이용해서 변경 가능
		stringDate = now.format(DateTimeFormatter.ofPattern("a hh:mm yyyy-MM-dd"));
		System.out.println(stringDate);
		// LocalDateTime.now().format(DateTimeFormatter.ofPattern("a hh:mm yyyy-MM-dd"));
	}
}
