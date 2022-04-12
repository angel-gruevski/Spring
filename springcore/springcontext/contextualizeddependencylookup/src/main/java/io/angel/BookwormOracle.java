package io.angel;

public class BookwormOracle implements Oracle{

    private Encyclopedia ecyclopedia;

    public void setEncyclopedia(Encyclopedia encyclopedia) {
        this.ecyclopedia = encyclopedia;
    }

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - go see the world instead";
    }
}