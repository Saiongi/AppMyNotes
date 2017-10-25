SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


CREATE TABLE `notes` (
  `note_id` int(11) NOT NULL,
  `note` varchar(255) NOT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_done` int(1) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;


INSERT INTO `notes` (`note_id`, `note`, `createdate`, `is_done`) VALUES
(1, 'Do some exercise ', '2017-10-25 02:05:50', 0),
(2, 'Drink cup of tea', '2017-10-25 02:05:59', 1),
(3, 'Read the book', '2017-10-25 02:06:18', 1),
(4, 'Eat brownies with Suzanne Y.', '2017-10-25 02:09:47', 1),
(5, 'Meet the deadline with Mark.', '2017-10-25 02:10:02', 0),
(6, 'Talk to George about his daughter', '2017-10-25 02:10:16', 0),
(7, 'Drink coffee with Rich', '2017-10-25 02:10:26', 0),
(8, 'Make a good impression on Chris', '2017-10-25 02:10:38', 0),
(9, 'Smile at Paul L.', '2017-10-25 02:10:50', 1),
(10, 'Confide in Lisa', '2017-10-25 02:10:59', 0),
(11, 'Work on a project with Donna R.', '2017-10-25 02:11:11', 1),
(12, 'Get to know Yolanda', '2017-10-25 02:11:23', 1),
(13, 'Call the client with Nick', '2017-10-25 02:11:33', 1),
(14, 'Contribute to the book drive organized by Karen', '2017-10-25 02:11:42', 0),
(15, 'Hang out with Millie', '2017-10-25 02:11:57', 0),
(16, 'Give career advice to Suzanne P', '2017-10-25 02:12:09', 0),
(17, 'Laugh with Donna G', '2017-10-25 02:12:19', 0),
(18, 'Watch Mary Ellen cut through the bull', '2017-10-25 02:12:29', 0),
(19, 'Drink beer with Paul B.', '2017-10-25 02:12:39', 1),
(20, 'Have a meeting with Dave W.', '2017-10-25 02:12:50', 1),
(21, 'Leave a message with Andrea', '2017-10-25 02:13:01', 1);

ALTER TABLE `notes`
  ADD PRIMARY KEY (`note_id`);
ALTER TABLE `notes`
  MODIFY `note_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;