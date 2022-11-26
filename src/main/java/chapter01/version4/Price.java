package chapter01.version4;

abstract class Price {
    abstract int getPriceCode();

    // refToVer4: 메서드 이동
//    double getCharge(int daysRented) { // refToVer4: 본인 객체의 데이터로 switch문을 진행할 수 있도록 메서드 옮김(Rental -> Movie)
//        double result = 0;
//        // 비디오 종류별 대여료 계산
//        switch (getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (daysRented > 2)
//                    result += (daysRented - 2) * 1.5;
//                break;
//            case Movie.NEW_RELEASE:
//                result += daysRented * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (daysRented > 3)
//                    result += (daysRented - 3) * 1.5;
//                break;
//        }
//        return result;
//    }
    // refToVer4: 조건문을 재정의로 전환
    abstract double getCharge(int daysRented);

    int getFrequentRentalPoints(int daysRented) { // refToVer4: 본인 객체의 데이터로 조건 비교 진행할 수 있도록 메서드 옮김(Rental -> Movie)
        return 1;
    }
}
class ChildrensPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    double getCharge(int daysRented) { // refToVer4: 조건문을 재정의로 전환
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}

class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) { // refToVer4: 조건문을 재정의로 전환
        return daysRented * 3;
    }

    int getFrequentRentalPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}

class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }

    double getCharge(int daysRented) { // refToVer4: 조건문을 재정의로 전환
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}