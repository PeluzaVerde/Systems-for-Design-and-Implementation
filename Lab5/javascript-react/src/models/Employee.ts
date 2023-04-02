import { RestaurantEmployee } from "./RestaurantEmployee";

export interface Employee {
    id: number;
    age: string;
    salary: number;
    name: string;
    restaurant: string;
    intern: boolean;
    restaurantEmployees: RestaurantEmployee;


}