package com.tommy_hoang_p0.Util;

import java.util.Scanner;

@FunctionalInterface
public interface Validator{
     boolean isValid(Scanner scn, String err);
}
