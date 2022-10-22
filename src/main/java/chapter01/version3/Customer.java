package chapter01.version3;

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
        Enumeration rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록" + System.lineSeparator();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + System.lineSeparator();
        }

        // 푸터 행 추가
        result += "누적 대여료 : " + String.valueOf(getTotalCharge()) + System.lineSeparator();
        result += "적립 포인트 : " + String.valueOf(getTotalFrequentRenterPoints()); // rftToV3: 임시 변수를 메서드 호출로 교체(totalAmount -> getTotalCharge())

        return result;
    }
    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<h1><em>" + "</em></h1>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result = each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<br/>\n";
        }

        result += "누적 대여료 : <em>" + String.valueOf(getTotalCharge()) + "</em>\n";
        result += "적립 포인트 : <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em>";

        return result;
    }

    // rftToV3: 임시 변수를 메서드 호출로 교체(totalAmount -> getTotalCharge())
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }
    // rftToV3: 임시 변수를 메서드 호출로 교체(frequentRenterPoints -> getTotalFrequentRenterPoints())
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;
    }

}
