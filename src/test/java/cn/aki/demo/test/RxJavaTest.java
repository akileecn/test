package cn.aki.demo.test;

import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/5.
 */
public class RxJavaTest {

	@Test
	public void flowableTest(){
		// 为了解决Backpressure
		Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
			@Override
			public void subscribe(FlowableEmitter<String> e) throws Exception {
				System.out.println("subscribe thread:" + Thread.currentThread().getName());
				e.onNext("hello");
				e.onNext("world");
				e.onNext("!");
				e.onComplete();
			}
		}, BackpressureStrategy.DROP); // 生产大于消费时的处理策略

		// 只需要onNext方法
		flowable.subscribe(System.out::println);
		// 完整
		flowable.subscribe(new Subscriber<String>() {
			@Override
			public void onSubscribe(Subscription s) {
				s.request(2); // 默认为0,不触发onNext
				System.out.println("onSubscribe");
			}

			@Override
			public void onNext(String s) {
				System.out.println("onNext");
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("onError");
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}
		});

	}


	@Test
	public void observerTest() throws Exception {
		// Observable -> Observable -> ...
		// subscribeOn第一个起作用，observeOn都起作用
		// s2 -> s1 -> s0 -> -> o1 -> o2 -> o3
		Observable.create(e -> {
			showThread("create");
			for (int i = 0; i < 5; i++) {
				Thread.sleep(100);
				e.onNext(i);
			}
			e.onComplete();
		})
				.subscribeOn(Schedulers.io()) // 设置被观察者运行的线程
				.throttleFirst(200, TimeUnit.MILLISECONDS) // 去抖动
				.map(i -> {
					showThread("map");
					return "000" + i;
				}) // 参数转化,接口方法返回对象
				.observeOn(Schedulers.newThread()) // 设置观察者运行的线程
				.flatMap(s -> {
					showThread("flatMap");
					return Observable.just(s);
				}) // 参数转化,接口方法返回Observable
				.compose(upstream -> upstream) // 参数转化,接口方法参数和返回都是Observable
				.subscribe(s -> showThread(s)); // 订阅并执行
		showThread("main");
		Thread.sleep(1000);
	}

	private void showThread(String remark){
		System.out.println("<" + remark + ">" + Thread.currentThread().getName());
	}
}
