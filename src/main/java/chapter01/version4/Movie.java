package chapter01.version4;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;
//    private int _priceCode;
    private Price _price; // refToVer4: 분류 부호를 상태/전략 패턴으로 전환

    public Movie(String title, int priceCode) {
        _title = title;
//        _priceCode = priceCode;
        setPriceCode(priceCode); // refToVer4: 직접 접근 대신 쓰기 메서드 사용
    }

    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }
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

    int getFrequentRentalPoints(int daysRented) { // refToVer4: 본인 객체의 데이터로 조건 비교 진행할 수 있도록 메서드 옮김(Rental -> Movie)
        return _price.getFrequentRentalPoints(daysRented);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("가격 코드가 잘못됐습니다.");
        }
    }

    public String getTitle() {
        return _title;
    }
}
