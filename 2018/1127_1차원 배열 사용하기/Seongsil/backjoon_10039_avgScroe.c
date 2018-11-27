/*baekjoon- 10039. Æò±Õ Á¡¼ö
Seongsil Heo */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define STUDENT_NUM 5

int main(void)
{
	int score;
	int total_score = 0;

	for (int i = 0; i < STUDENT_NUM; i++)
	{
		scanf("%d", &score);

		if (score < 40)
		{
			score = 40;
		}

		total_score += score;
	}

	int average = total_score / STUDENT_NUM;
	printf("%d", average);
	return 0;
}