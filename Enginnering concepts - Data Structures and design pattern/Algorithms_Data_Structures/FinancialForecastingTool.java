package Algorithms_Data_Structures;

public class FinancialForecastingTool {
    public static void main(String[] args) {


        /*
         ans.1 - Recursion simplifies a problem by breaking it into smaller subproblems and solving each subproblem using the same method until a base case is reached.
        --------------------------------------------------------------------------------------------------------------
        ans.2 created a method below to calculate the future value using a recursive approach.
        --------------------------------------------------------------------------------------------------------------
        ans. 3 -	Implemented a recursive algorithm to predict future values based on past growth rates.
        */
//              -----  Demo -----
        FinancialForecastingTool forecast = new FinancialForecastingTool();

        double futureValue = forecast.forecast(10000, 0.10, 5);

        System.out.println("Future Value = " + futureValue);

        /*
        --------------------------------------------------------------------------------------------------------------
         ans.4 -
         - Time Complexity: - O(n), because the recursive function makes one recursive call for each year.
         - It can be optimized by using an iterative approach, which reduces the extra space complexity from O(n) to O(1).
         - For recursive problems with overlapping subproblems (ex:Fibonacci), memoization or dynamic programming can be used to avoid repeated computation
         */

    }



    public double forecast(double value, double rate, int years){
        if(years == 0) return value;

        return forecast(value * (1 + rate), rate, years - 1);
    }
}
