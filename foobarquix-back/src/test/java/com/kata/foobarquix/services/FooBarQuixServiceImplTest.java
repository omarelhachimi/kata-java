package com.kata.foobarquix.services;

import com.kata.foobarquix.services.impl.FooBarQuixServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FooBarQuixServiceImplTest {


    //////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// FooBarQuixServiceImpl can be done in a more general way, meaning that the two maps get
    /// injected in the service, and service apply the logic independently of the maps
    ///
    /// The FooBarQuixServiceImplTest tests are not perfect two, because if we decide to change
    /// the number or the strings we will have to change tests code.
    ///
    /// The tests can be done also in a more general way
    ///
    /// For simplicity and time reasons i decided to keep the code this way and mention this here
    /// This code was coded in TDD, red test -> green test -> refactor
    ///
    //////////////////////////////////////////////////////////////////////////////////////////


    private static final String FOO = "Foo";
    private static final String BAR = "Bar";
    private static final String QUIX = "Quix";
    FooBarQuixServiceImpl fooBarQuixService = new FooBarQuixServiceImpl();


    /////////////////////////////////////////////////////////////////////////////////////
    // Test when number is not divided and does not contain any of the specified numbers
    /////////////////////////////////////////////////////////////////////////////////////
    @Test
    void Should_returnSameValue_when_numberIsNotDivisibleAndDoesNoContainAnyOfTheSpecifiedNumbersTest() {
        //Act & Assert
        assertThat(fooBarQuixService.convertNumber(1)).isEqualTo("1");
        assertThat(fooBarQuixService.convertNumber(8)).isEqualTo("8");
        assertThat(fooBarQuixService.convertNumber(88)).isEqualTo("88");
    }

    //////////////////////////////////////////////////
    // Tests when number divided by one of the numbers
    //////////////////////////////////////////////////

    @Test
    void Should_returnStringContainsFOO_when_numberIsDivisibleByThreeTest() {
        //Act
        String ResultConvert12 = fooBarQuixService.convertNumber(12);
        String ResultConvert37 = fooBarQuixService.convertNumber(21);

        //Assert
        assertThat(ResultConvert12).isEqualTo(FOO);
        assertThat(ResultConvert37).isEqualTo(FOO);
    }

    @Test
    void Should_returnStringContainsFoo_when_numberIsDivisibleByFiveTest() {
        //Act
        String ResultConvert13 = fooBarQuixService.convertNumber(10);
        String ResultConvert37 = fooBarQuixService.convertNumber(100);

        //Assert
        assertThat(ResultConvert13).isEqualTo(BAR);
        assertThat(ResultConvert37).isEqualTo(BAR);
    }

    @Test
    void Should_returnStringDoesNotContainsQUIX_when_numberIsDivisibleBySevenTest() {
        //Act
        String ResultConvert13 = fooBarQuixService.convertNumber(14);

        //Assert
        assertThat(ResultConvert13).isEqualTo("14");
        System.out.println(1 << 2);
    }


    /////////////////////////////////////////////////
    // Tests when number contains one of the numbers
    /////////////////////////////////////////////////

    @Test
    void Should_returnStringContainsFOO_when_numberContainsThreeTest() {
        //Act
        String ResultConvert13 = fooBarQuixService.convertNumber(13);
        String ResultConvert37 = fooBarQuixService.convertNumber(37);

        //Assert
        assertThat(ResultConvert13).isEqualTo(FOO);
        assertThat(ResultConvert37).isEqualTo(FOO + QUIX);
    }

    @Test
    void Should_returnStringContainsBAR_when_numberContainsFiveTest() {
        //Act
        String ResultConvert15 = fooBarQuixService.convertNumber(15);
        String ResultConvert55 = fooBarQuixService.convertNumber(55);

        //Assert
        assertThat(ResultConvert15).isEqualTo(FOO + BAR + BAR);
        assertThat(ResultConvert55).isEqualTo(BAR + BAR + BAR);
    }

    @Test
    void Should_returnStringContainsQUIX_when_numberContainsSevenTest() {
        //Act
        String ResultConvert7 = fooBarQuixService.convertNumber(7);
        String ResultConvert27 = fooBarQuixService.convertNumber(27);

        //Assert
        assertThat(ResultConvert7).isEqualTo(QUIX);
        assertThat(ResultConvert27).isEqualTo(FOO + QUIX);
    }


    ////////////////////////////////////////////////////////////////
    // Tests when number contains and divided by one of the numbers
    ////////////////////////////////////////////////////////////////
    @Test
    void Should_returnStringContainsMoreThanTwoFOO_when_numberContainsAndDivisibleByThreeTest() {
        //Act
        String ResultConvert33 = fooBarQuixService.convertNumber(33);
        String ResultConvert35 = fooBarQuixService.convertNumber(45);

        //Assert
        assertThat(ResultConvert33).isEqualTo(FOO + FOO + FOO);
        assertThat(ResultConvert35).isEqualTo(FOO + BAR + BAR);
    }

    @Test
    void Should_returnStringContainsMoreThanTwoBAR_when_numberContainsAndDivisibleByFiveTest() {
        //Act
        String ResultConvert55 = fooBarQuixService.convertNumber(55);
        String ResultConvert15 = fooBarQuixService.convertNumber(15);

        //Assert
        assertThat(ResultConvert55).isEqualTo(BAR + BAR + BAR);
        assertThat(ResultConvert15).isEqualTo(FOO + BAR + BAR);
    }

    @Test
    void Should_returnStringContainsMoreThanOneQUIX_when_numberContainsAndDivisibleBySevenTest() {
        //Act
        String ResultConvert17 = fooBarQuixService.convertNumber(17);
        String ResultConvert77 = fooBarQuixService.convertNumber(77);
        String ResultConvert72 = fooBarQuixService.convertNumber(72);

        //Assert
        assertThat(ResultConvert17).isEqualTo(QUIX);
        assertThat(ResultConvert77).isEqualTo(QUIX + QUIX);
        assertThat(ResultConvert72).isEqualTo(FOO + QUIX);
    }


}
