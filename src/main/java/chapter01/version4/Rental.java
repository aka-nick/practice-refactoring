package chapter01.version4;

public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    double getCharge() { // refToVer4: 본인 객체의 데이터로 switch문을 진행할 수 있도록 메서드 옮김(Rental -> Movie)
        return _movie.getCharge(_daysRented);
    }

    int getFrequentRentalPoints() { // refToVer4: 본인 객체의 데이터로 조건 비교 진행할 수 있도록 메서드 옮김(Rental -> Movie)
        return _movie.getFrequentRentalPoints(_daysRented);
    }

}
