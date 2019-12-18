package com.workbook.liuwb.workbook.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.workbook.liuwb.workbook.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
//        runBasicRxCode();
        runError();
    }

    /**
     * 会造成背压的情况
     */
    @SuppressLint("CheckResult")
    private void runError() {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            int i = 0;
            while (true) {
                i++;
                emitter.onNext(i + "");
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(s -> {
                    Thread.sleep(3000);
                });
    }

    /**
     * 最为普通的使用
     */
    private void runBasicRxCode() {
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("111");
            emitter.onNext("222");
            emitter.onNext("333");
            emitter.onNext("444");
            emitter.onNext("555");
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
