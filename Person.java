class Person {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    String getName() {
        return name;
    }

    String getId() {
        return id;
    }

    void introduce() {
        System.out.println("I am a person");
    }
}