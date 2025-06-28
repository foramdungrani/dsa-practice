package Optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optName = Optional.ofNullable(getName());
        optName.ifPresent(System.out::println);

        String result1 = optName.orElse(fetchFromDB());
        System.out.println(result1);

        String result2 = optName.orElseGet(() -> fetchFromDB());
        System.out.println(result2);

        String result3 = optName.orElseThrow(() -> new RuntimeException("default"));
        System.out.println(result3);

        getUserCity(new User());
    }

    static String getName() {
        return "foram";
    }

    static String fetchFromDB() {
        System.out.println("Fetching from DB...");
        return "DB_Name";
    }

    public static String getUserCity(User user) {
        return Optional.ofNullable(user)
                .flatMap(User::getProfile)     // Optional<Profile>
                .flatMap(Profile::getAddress)  // Optional<Address>
                .map(Address::getCity)         // Optional<String>
                .orElse("Unknown City");       // Fallback if any level is missing
    }

    public static String getValidDomain(String email) {
        return Optional.ofNullable(email)
                .map(e -> e.substring(e.indexOf("@") + 1))    // extract domain
                .filter(domain -> domain.endsWith(".com"))    // only allow .com
                .orElse("invalid.com");                       // fallback
    }
}


class User {
    private Profile profile;
    public Optional<Profile> getProfile() { return Optional.ofNullable(profile); }
}

class Profile {
    private Address address;
    public Optional<Address> getAddress() { return Optional.ofNullable(address); }
}

class Address {
    private String city;
    public String getCity() { return city; }
}