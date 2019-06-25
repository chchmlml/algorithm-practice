//package io.haicheng;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * <p>Title: LinkedListCycle</p>
// * <p>Description: </p>
// *
// * @author haicheng
// * @Email haicheng@staff.weibo.com
// * @date 2019/6/19 13:56
// */
//public class LinkedListCycle {
//
//    class ListNode {
//
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
//
//    public class Solution {
//
//        public ListNode hasCycle(ListNode head, int k) {
//
//            ListNode pre = new ListNode(0);
//            pre.next = head;
//            while (pre != null) {
//
//                int flag = k;
//                while (flag > 0) {
//
//
//                    pre = pre.next;
//                    flag--;
//                }
//            }
//
//            //                if (null == head) {
//            //                    return false;
//            //                }
//            //                ListNode slow = head;
//            //                ListNode fast = head;
//            //                while (slow != null && fast != null && fast.next != null) {
//            //
//            //                    slow = slow.next;
//            //                    fast = fast.next.next;
//            //
//            //                    if (slow == fast) {
//            //                        return true;
//            //                    }
//            //                    head = head.next;
//            //                }
//            //                return false;
//
//            //            Set<ListNode> mapPos = new HashSet<ListNode>();
//            //            ListNode dummyHead = new ListNode(-1);
//            //            dummyHead.next = head;
//            //            ListNode cur = dummyHead;
//            //            while (null != cur) {
//            //
//            //                if (mapPos.contains(cur)) {
//            //                    return cur;
//            //                }
//            //
//            //                mapPos.add(head);
//            //                cur = cur.next;
//            //            }
//            //
//            //            return null;
//
//        }
//    }
//}
