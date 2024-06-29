package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) {
        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Resource is missing", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Resource error", e);
        } catch (ArithmeticException e) {
            System.err.println("ar");
        } catch (NumberFormatException e) {
            System.err.println("nfe");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("ioobe");
        } catch (UnsupportedOperationException e) {
            System.err.println("uoe");
        } catch (Exception e) {
            System.err.println("Unhandled exception occurred: " + e.getMessage());
        }
    }

}