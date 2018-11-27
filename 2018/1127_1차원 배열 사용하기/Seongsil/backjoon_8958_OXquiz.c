/*baekjoon- 8958. OX퀴즈
Seongsil Heo */
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main(void)
{
	char ox[80]; 
	int cases;

	scanf("%d", &cases);
	
	for (int i = 0; i < cases; i++)
	{
		scanf("%s", &ox);

		int score = 0;
		int total_score = 0;

		for (int j = 0; j < strlen(ox); j++)
		{
			if (ox[j] == 'O')
			{
				score++; 
				total_score += score;
			}

			else if (ox[j] == 'X')
			{
				score = 0;
			}
			else
			{
				break;
			}
			
		}
		printf("%d\n", total_score);
	}


	return 0;

}
