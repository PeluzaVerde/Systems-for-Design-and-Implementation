import { RestaurantEmployee } from "./RestaurantEmployee";

export interface Restaurant {
    id: number;
    name: string;
    description: string;
    rating: number;
    date: string;
    city: string;
    restaurantEmployees: RestaurantEmployee;
    

}