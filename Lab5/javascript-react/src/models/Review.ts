import { Employee } from "./Employee";


export interface Review {
    id: number;
    username: string;
    description: string;
    rating: number;
    date: string;
    recommend: boolean;
    employee: Employee;

}