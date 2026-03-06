#include <stdio.h>
void calculateSJF_NonPreemptive(int processes[], int n, int burst_time[]){
    for(int i = 0; i<n-1; i++){
        for(int j = i+1; j<n; j++){
            if(burst_time[i]>burst_time[j]){
                int temp_bt = burst_time[i];
                burst_time[i] = burst_time[j];
                burst_time[j] = temp_bt;

                int temp_p = processes[i];
                processes[i] = processes[j];
                processes[j] = temp_p;
            }
        }
    }

    int wait_time[n];
    wait_time[0] = 0;
    printf("Process %d: Wait Time = 0\n", processes[0]);
    for(int i = 1; i<n; i++){
        wait_time[i] = burst_time[i-1] + wait_time[i-1];
        printf("Process %d: Wait Time = %d\n", processes[i], wait_time[i]);
    }
}

int main(){
    int processes[] = {1,2,3,4};
    int n = 4;
    int burst_time[] = {21,3,6,2};
    printf("---SJF(Non-Preemptive)---\n");
    calculateSJF_NonPreemptive(processes, n, burst_time);
    return 0;
}