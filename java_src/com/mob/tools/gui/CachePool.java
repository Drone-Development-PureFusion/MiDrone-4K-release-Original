package com.mob.tools.gui;

import com.mob.tools.MobLog;
/* loaded from: classes.dex */
public class CachePool<K, V> {
    private int capacity;
    private Node<K, V> head;
    private int size;
    private Node<K, V> tail;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Node<K, V> {
        private long cacheTime;
        public K key;
        public Node<K, V> next;
        public Node<K, V> previous;
        public V value;

        private Node() {
        }
    }

    public CachePool(int i) {
        this.capacity = i;
    }

    public synchronized void clear() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public synchronized V get(K k) {
        V v = null;
        synchronized (this) {
            if (this.head != null) {
                if (!this.head.key.equals(k)) {
                    Node<K, V> node = this.head;
                    while (true) {
                        if (node.next == null) {
                            break;
                        }
                        node = node.next;
                        if (node.key.equals(k)) {
                            if (node.next == null) {
                                node.previous.next = null;
                                this.tail = node.previous;
                            } else {
                                node.previous.next = node.next;
                                node.next.previous = node.previous;
                            }
                            node.previous = null;
                            node.next = this.head;
                            this.head.previous = node;
                            this.head = node;
                            v = node.value;
                        }
                    }
                } else {
                    v = this.head.value;
                }
            } else {
                this.size = 0;
                this.tail = null;
            }
        }
        return v;
    }

    public synchronized boolean put(K k, V v) {
        boolean z = true;
        synchronized (this) {
            if (k != null) {
                if (this.capacity > 0) {
                    Node<K, V> node = null;
                    while (this.size >= this.capacity) {
                        node = this.tail;
                        if (node == null) {
                            MobLog.getInstance().m5960w("size != 0 but tail == null, this must meet any mistake! fix me!!", new Object[0]);
                            Node<K, V> node2 = this.head;
                            if (node2 == null) {
                                this.size = 0;
                                this.tail = null;
                            } else {
                                this.size = 1;
                                while (node2.next != null) {
                                    this.size++;
                                    node2 = node2.next;
                                }
                                this.tail = node2;
                            }
                        } else {
                            this.tail = this.tail.previous;
                            this.tail.next = null;
                            this.size--;
                        }
                    }
                    if (node == null) {
                        node = new Node<>();
                    }
                    ((Node) node).cacheTime = System.currentTimeMillis();
                    node.key = k;
                    node.value = v;
                    node.previous = null;
                    node.next = this.head;
                    if (this.size == 0) {
                        this.tail = node;
                    } else if (this.head != null) {
                        this.head.previous = node;
                    } else {
                        MobLog.getInstance().m5960w("size != 0 but head == null, this must meet any mistake! fix me!!", new Object[0]);
                        this.tail = node;
                        this.size = 0;
                    }
                    this.head = node;
                    this.size++;
                }
            }
            z = false;
        }
        return z;
    }

    public int size() {
        return this.size;
    }

    public synchronized void trimBeforeTime(long j) {
        if (this.capacity > 0) {
            for (Node<K, V> node = this.head; node != null; node = node.next) {
                if (((Node) node).cacheTime < j) {
                    if (node.previous != null) {
                        node.previous.next = node.next;
                    }
                    if (node.next != null) {
                        node.next.previous = node.previous;
                    }
                    if (node.equals(this.head)) {
                        this.head = this.head.next;
                    }
                    this.size--;
                }
            }
        }
    }
}
