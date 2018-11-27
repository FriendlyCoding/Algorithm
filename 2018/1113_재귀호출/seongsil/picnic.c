/*알고리즘 문제 해결 전략
p.157 소풍*/
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdbool.h>

#define MAXLENGTH 10

int countPairings(int n, bool taken[MAXLENGTH],bool areFriends[MAXLENGTH][MAXLENGTH]);
int friend_num;
int main(void)
{
	FILE *file;
	int cases;
	int student_num; //학생의 수
	int student1, student2;
	bool areFriends[MAXLENGTH][MAXLENGTH]; //친구 여부 확인

	file = fopen("input.txt", "r");
	fscanf(file, "%d", &cases);
	for (int i = 0; i < cases; i++) // 0 : A
	{
		bool taken[MAXLENGTH];

		fscanf(file, "%d %d", &student_num, &friend_num);
		for (int j = 0; j < friend_num; j++)
		{
			fscanf(file, "%d %d", &student1, &student2);
			areFriends[student1][student2] = true;
		}
		printf("%d\n",countPairings(friend_num,taken,areFriends));
	}
}

int countPairings(int n, bool taken[MAXLENGTH],bool areFriends[MAXLENGTH][MAXLENGTH]){
	//기저 사례: i번째 학생이 짝을 이미 찾았으면 true, 아니면 false

	int firstFree = -1;
	for (int i = 0; i < n; ++i)
	{
		if (!taken[i]) {
			firstFree = i;
			break;
		}

		//기저 사례: 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았은니 종료한다.
		if (firstFree == -1){
			return 1;
		}

		int ret = 0;
		//이 학생과 짝지을 학생을 결정
		for (int pairWith = firstFree + 1; pairWith <n; ++pairWith)
		{
			if (!taken[pairWith] && !taken[pairWith] && areFriends[firstFree][pairWith])
			{
				taken[pairWith] = taken[pairWith] = true;
				ret += countPairings(friend_num, taken,areFriends);
				taken[firstFree] = taken[pairWith] = false;

			}
		}
		return ret;
	}
}