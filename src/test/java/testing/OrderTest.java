package testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder(){
        //System.out.println("Inside @BeforeEach method");
        order = new Order();
    }

    @AfterEach
    void cleanUp(){
        //System.out.println("Inside @AfterEach method");
        order.cancel();
    }

    @Test
    void testAssertArrayEquals(){
        //given
        int[] ints1 = {1,2,3};
        int[] ints2 = {1,2,3};


        //then
        assertArrayEquals(ints1,ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder(){
        //then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(),equalTo(0));
        assertThat(order.getMeals(),hasSize(0));
        assertThat(order.getMeals(),emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize(){
        //given
        Meal meal = new Meal(15,"burger");
        Meal meal2 = new Meal(7,"sandwich");


        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals(),hasSize(1));
        assertThat(order.getMeals(),contains(meal));
        assertThat(order.getMeals(),hasItem(meal));
        assertThat(order.getMeals().get(0).getPrice(), equalTo(15));
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize(){
        //given
        Meal meal = new Meal(15,"burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals(),hasSize(0));
        assertThat(order.getMeals(),not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder(){
        //given
        Meal meal = new Meal(15,"burger");
        Meal meal2 = new Meal(7,"sandwich");

        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals(), containsInAnyOrder(meal2,meal));
    }

    @Test
    void testIfTwoMealListAreTheSame(){
        Meal meal = new Meal(15,"burger");
        Meal meal2 = new Meal(7,"sandwich");

        List<Meal> meals1 = Arrays.asList(meal,meal2);
        List<Meal> meals2 = Arrays.asList(meal,meal2);

        assertThat(meals1,is(meals2));


    }


}
