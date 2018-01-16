#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>

#include <rtdk.h>
#include <native/task.h>

static void task_cb(void *arg)
{
  while(1)
  {
    rt_printf("Hello Xenomai!\n");
    rt_task_sleep(1000000000LL); // 1 second
  }
}

int main(int argc, char** argv)
{
  RT_TASK task;
  int ret = -1;

  mlockall(MCL_CURRENT | MCL_FUTURE);

  ret = rt_task_spawn(&task, "Hello Xenomai", 0, 99, T_JOINABLE, &task_cb,
      NULL);

  if(ret != 0)
  {
    fprintf(stderr, "Error rt_task_spawn: %d\n", ret);
    exit(EXIT_FAILURE);
  }

  rt_task_join(&task);
  return EXIT_SUCCESS;
}

