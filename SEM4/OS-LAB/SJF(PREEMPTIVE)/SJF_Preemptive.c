#include <stdio.h>
#include <stdbool.h>

void calculateSJF_Preemptive(int processes[], int n, int burst_time[], int arrival_time[]){
    int remaining_time[n];
    for(int i = 0; i<n; i++){
        remaining_time[i] = burst_time[i];
    }
    int complete = 0, current_time = 0, shortest = 0, min_remaining = 9999;
    bool check = false;
    while(complete != n){
        for(int j = 0; j<n; j++){
            if((arrival_time[j]<=current_time)&&(remaining_time[j]<min_remaining)&&(remaining_time[j]>0)){
                min_remaining = remaining_time[j];
                shortest = j;
                check = true;
            }
        }
        if(check == false){
            current_time++;
            continue;
        }
        remaining_time[shortest]--;
        min_remaining = remaining_time[shortest];
        if(min_remaining == 0){
            min_remaining = 9999;
            complete++;
            check = false;
            int finish_time = current_time+1;
            int tat = finish_time - arrival_time[shortest];
            int wt = tat - burst_time[shortest];
            printf("Process %d completed at time %d | Wait: %d | Turnaround: %d\n", processes[shortest], finish_time, wt, tat);
        }
        current_time++;
    }
}

int main(){
    int processes[] = {1,2,3};
    int n = 3;
    int arrival_time[] = {0,1,2};
    int burst_time[] = {1,4,9};
    printf("---SFJ(Preemptive)---\n");
    calculateSJF_Preemptive(processes, n, burst_time, arrival_time);
    return 0;
}