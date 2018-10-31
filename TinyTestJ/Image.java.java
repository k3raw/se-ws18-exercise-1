����   6 t  Image  java/lang/Object height I width data [B rgb colorRgb index val valRgb <init> (II)V Code
     ()V ���	    	    	    	    	    	 LineNumberTable LocalVariableTable this LImage; set (III)V	  '  
 ) + * java/nio/ByteBuffer , - allocate (I)Ljava/nio/ByteBuffer;
 ) / 0 1 array ()[B
  3 4 5 	linearize (II)I x y Ljava/nio/ByteBuffer; rgba write (Ljava/lang/String;)V 
Exceptions > java/io/IOException @ java/io/FileWriter
 ? B  ; D java/io/BufferedWriter
 C F  G (Ljava/io/Writer;)V I java/lang/StringBuilder K p6	
 H B
 H N O P append (I)Ljava/lang/StringBuilder; R 	
 H T O U -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 H W X Y toString ()Ljava/lang/String;
 C [ : ;
 C ] ^  newLine
 ` b a java/lang/String c d valueOf (I)Ljava/lang/String;
 C f g  close filename Ljava/lang/String; 
filewriter Ljava/io/FileWriter; bufferwriter Ljava/io/BufferedWriter; 	exercise1 i j StackMapTable 
SourceFile 
Image.java !                  	    
                                }     '*� *� * �� *� *� *hh�� �              
 
        &  !        ' " #     '      '     $ %     �     G**� ~� &� (:� .:*� 2h6*� 3T*� `3T*� `3T�        "     
      !  ,  9   F " !   H    G " #     G 6     G 7     G     7  8   0 9 	  ! &     : ;  <     =   �     һ ?Y+� AM� CY,� EN� HYJ� L*� � MQ� S*� � MQ� S� V:-� Z6� �-� \6� m*� 2h6-� HY*� 3� _� LQ� S� V� Z-� HY*� `3� _� LQ� S� V� Z-� HY*� `3� _� LQ� S� V� Z�*� ����*� ��z-� e�        >    & 	 '  ) 8 * > + D , H - N . Z / w 0 � 1 � - � + � 5 � 7 !   R    � " #     � h i  	 � j k   � l m  8 � n i  A � o   K v p   Z [    q   # � D   ` ? C `  � 	� i�   4 5     G     	*� h`�            : !        	 " #     	 6     	 7    r    s