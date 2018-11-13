/*�˰��� ���� �ذ� ����
p.157 ��ǳ*/
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
	int student_num; //�л��� ��
	int student1, student2;
	bool areFriends[MAXLENGTH][MAXLENGTH]; //ģ�� ���� Ȯ��

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
	//���� ���: i��° �л��� ¦�� �̹� ã������ true, �ƴϸ� false

	int firstFree = -1;
	for (int i = 0; i < n; ++i)
	{
		if (!taken[i]) {
			firstFree = i;
			break;
		}

		//���� ���: ��� �л��� ¦�� ã������ �� ���� ����� ã������ �����Ѵ�.
		if (firstFree == -1){
			return 1;
		}

		int ret = 0;
		//�� �л��� ¦���� �л��� ����
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