package chapter01.version2;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록" + System.lineSeparator();

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // 비디오 종류별 대여료 계산 함수 호출
//            thisAmount = amountFor(each); // rftToV2: 메서드 분리
//            thisAmount = each.getCharge(); // rftToV2: 메서드 이동(Customer -> Rental), 임시변수 제거

//            // 적립 포인트를 1 포인트 증가 // rftToV2: 메서드 분리 & 이동
//            frequentRenterPoints++;
//            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
//            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
//                frequentRenterPoints++;
            frequentRenterPoints += each.getFrequentRentalPoints();

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + System.lineSeparator(); // rftToV2: 임시 변수를 메서드 호출로 교체

            // 현재까지 누적된 총 대여료
            totalAmount += each.getCharge(); // rftToV2: 임시 변수를 메서드 호출로 교체
        }

        // 푸터 행 추가
        result += "누적 대여료 : " + String.valueOf(totalAmount) + System.lineSeparator();
        result += "적립 포인트 : " + String.valueOf(frequentRenterPoints);

        return result;
    }

//    private double amountFor(Rental aRental) { // rftToV2: 메서드 분리, 메서드 내 변수명 수정, 메서드 이동(Customer -> Rental)
//        double result = 0;
//        // 비디오 종류별 대여료 계산
//        switch (aRental.getMovie().getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (aRental.getDaysRented() > 2)
//                    result += (aRental.getDaysRented() - 2) * 1.5;
//                break;
//            case Movie.NEW_RELEASE:
//                result += aRental.getDaysRented() * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (aRental.getDaysRented() > 3)
//                    result += (aRental.getDaysRented() - 3) * 1.5;
//                break;
//        }
//        return result;
//    }
}
