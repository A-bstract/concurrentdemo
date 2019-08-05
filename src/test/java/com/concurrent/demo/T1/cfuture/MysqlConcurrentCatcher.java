package com.concurrent.demo.T1.cfuture;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public abstract class MysqlConcurrentCatcher<V, C> implements ConcurrentCatcher<V, C> {
    ExecutorService executor = Executors.newFixedThreadPool(20);

    private List<C> conditions;

    public ConcurrentCatcher setConditions(List<C> conditions) {
        this.conditions = conditions;
        return this;
    }

    private Map<C, List<V>> results = new ConcurrentHashMap<>();

    @Override
    public void doCatch() {

        //1.conditions为查询条件集合

        //2.每个条件将作为一个独立线程处理，用线程池executor维护线程
        //3.调用fetch方法获取dao层逻辑
        //4.并处理完之后，将对象结果通过apply()方法进行封装

        CompletableFuture[] futures = conditions.stream().map(c -> CompletableFuture.supplyAsync(() -> this.fetch(c),executor).whenCompleteAsync((s, t)->this.apply(c,s))).toArray(CompletableFuture[]::new);

        //等待所有list工作已完成
        CompletableFuture.allOf(futures).join();

        //获取全部数据之后的逻辑
        after();
    }

    /**
     * 用于处理获取到数据后的业务逻辑,此处可扩展为抓去玩数据之后进行的逻辑处理或封装
     * @param condition
     * @param list
     */
    public void apply(C condition,List<V> list){
        //1.此处仅将集合使用map进行存储
        results.put(condition,list);
    }

    /**
     * 获取数据集合的过程，即调用dao层逻辑的过程
     * @param condition
     * @return
     */
    public abstract List<V> fetch(C condition);

    /**
     * 阻塞之后
     */
    protected abstract void after();
}