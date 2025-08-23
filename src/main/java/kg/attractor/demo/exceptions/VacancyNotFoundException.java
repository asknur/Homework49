package kg.attractor.demo.exceptions;

public class VacancyNotFoundException extends NotFoundException {
    public VacancyNotFoundException() {
        super("Vacancy");
    }
}
