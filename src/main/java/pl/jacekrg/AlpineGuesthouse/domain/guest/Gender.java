package pl.jacekrg.AlpineGuesthouse.domain.guest;

public enum Gender {
    MALE("Mężczyzna"), FEMALE("Kobieta");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return this.gender;
    }
}
