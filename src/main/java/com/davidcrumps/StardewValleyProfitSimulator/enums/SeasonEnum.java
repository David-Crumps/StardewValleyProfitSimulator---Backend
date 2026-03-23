package com.davidcrumps.StardewValleyProfitSimulator.enums;

public enum SeasonEnum {
    SPRING(1), SUMMER(2), FALL(3), WINTER(4);

    private final int order;
    SeasonEnum(int order) {this.order = order;}
    public int getOrder() {return order;}
}
