package pl.isa.BackendBoys.jsonService;

import pl.isa.BackendBoys.request.Request;
import pl.isa.BackendBoys.user.User;

import java.util.ArrayList;
import java.util.List;

 class ExampleData {

     List<User> createExampleUsers() {
        List<User> exampleUsers = new ArrayList<>();
        exampleUsers.add(new User("John", "111-111-111", "john@wp.pl", "john", "Gdynia"));
        exampleUsers.add(new User("Mark", "222-222-222", "mark@wp.pl", "mark", "Warszawa"));
        exampleUsers.add(new User("Thomas", "333-333-333", "thomas@wp.pl", "thomas", "Bialystok"));
        exampleUsers.add(new User("Peter", "444-444-444", "Peter@wp.pl", "peter", "Szczecin"));

        return exampleUsers;
    }

     List<Request> createExampleRequests() {
        List<Request> exampleRequests = new ArrayList<>();

        exampleRequests.add(new Request("john@wp.pl", Request.LostOrFound.LOST, "kluczyki", "zgugiono na parkingu przy biedronce na ulicy xxx", "Gdynia"));
        exampleRequests.add(new Request("john@wp.pl", Request.LostOrFound.FOUND, "portfel", "znalazlem na parkingu przy lidlu na ulicy xxx", "Gdynia"));
        exampleRequests.add(new Request("mark@wp.pl", Request.LostOrFound.LOST, "worek z kasa", "15.04 znalazlem przy przystanku (ul. ABC) worek a w nim 40k PLN", "Warszawa"));
        exampleRequests.add(new Request("mark@wp.pl", Request.LostOrFound.LOST, "Dziewczyna", "Poszukuje dziewczyny do towarzystwa 20.05 na wesele", "Warszawa"));
        exampleRequests.add(new Request("thomas@wp.pl", Request.LostOrFound.LOST, "Kia Cerato", "Skradziono mi spod domu na Lipowej, zielony hatchback", "Białystok"));
        exampleRequests.add(new Request("thomas@wp.pl", Request.LostOrFound.LOST, "wiare w ludzi", "bylem swiadkiem jak mlodzieniec oszukal pania w sklepie, co sie dzieje z tą młodzieżą", "Białystok"));
        exampleRequests.add(new Request("Peter@wp.pl", Request.LostOrFound.FOUND, "torebkę damksą", "W galerii handlowej xxx. Zielona ze skóry aligatora", "Szczecin"));
        exampleRequests.add(new Request("Peter@wp.pl", Request.LostOrFound.FOUND, "komórkę", "Biały iphone w autobisue linii 222", "Szczecin"));

        return exampleRequests;
    }

}
