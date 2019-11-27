package guru.springframework.services;

public class PrimaryGreetingService implements GreetingService {
    private GreetingRepository greetingRepository;
    PrimaryGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
