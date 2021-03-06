package cn.bittx.job.conf;

import cn.bittx.job.bean.Platform;
import cn.bittx.job.repo.PlatformRepo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class JobConf {

    @Resource
    private PlatformRepo platformRepo;

    @Resource
    private JobBuilderFactory jobBuilderFactory;

    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloWorldJob(){
        return jobBuilderFactory.get("helloWorld")
                .start(step1())
                .next(step2())
                .next(step3())
                .build();
    }

    @Bean
    public Job helloWorldJobCondition(){
        return jobBuilderFactory.get("condition")
                .start(step1()).on("COMPLETED")
                .to(step2())
                .from(step2()).on("COMPLETE").to(step3())
                .from(step3()).end()
                .build();
    }



    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Hello Spring Batch, Step 1");
                        System.out.println(platformRepo.getVersion());
                        Platform p = new Platform();
                        p.setVersion("ha.cn " + System.currentTimeMillis());
                        platformRepo.saveAndFlush(p);
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step step2(){
        return stepBuilderFactory.get("step2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Hello Step 2");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step step3(){
        return stepBuilderFactory.get("step3")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Hello step 3");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
