package com.truenorth.calculator.Util;

import com.truenorth.calculator.model.OperationType;

public enum Values {




//    public static OperationType ADDITION = new OperationType(3);
//    public static OperationType SUBSTRACTION = new OperationType(4);
//    public static OperationType MULTIPLICATION = new OperationType(5);
//    public static OperationType DIVISION = new OperationType(6);
//    public static OperationType SQUARE_ROOT = new OperationType(7);
//    public static OperationType RANDOM_STRING = new OperationType(8);


    ADDITION(3),
    SUBSTRACTION(4),
    MULTIPLICATION(5),
    DIVISION(6),
    SQUARE_ROOT(7),
    RANDOM_STRING(8),
    ACTIVE(1),
    INACTIVE(2)
    ;

    public final Integer value;

    private Values(Integer value) {
        this.value = value;
    }

}
