import { Employee } from "./Employee";
import { Restaurant } from "./Restaurant";

export interface RestaurantEmployee {
    id: number;
    numberOfWriteUps: number;
    boss: string;
    hours: number;
    parttime: boolean;
    remote: boolean;
    employee: Employee;
    restaurant: Restaurant;

    

}