#include <stdio.h>
void calculateFCFS(int processes[], int n, int burst_time[]){
    int wait_time[n], turnaround_time[n];
    float total_wt = 0, total_tat = 0;
    wait_time[0] = 0;
    for(int i = 1; i<n; i++){
        wait_time[i] = burst_time[i-1]+wait_time[i-1];
    }
    for(int i = 0; i<n; i++){
        turnaround_time[i] = burst_time[i]+wait_time[i];
        total_wt += wait_time[i];
        total_tat += turnaround_time[i];
        printf("Process %d: Burst Time = %d, Wait Time = %d, Turnaround Time = %d\n", processes[i], burst_time[i], wait_time[i], turnaround_time[i]);
    }
    printf("\nAverage Waiting Time: %.2f", (total_wt/n));

}

int main(){
    int processes[] = {1,2,3};
    int n = sizeof(processes)/sizeof(processes[0]);
    int burst_time[] = {10, 5, 8};
    printf("---FCFS---\n");
    calculateFCFS(processes, n, burst_time);
    return 0;
}