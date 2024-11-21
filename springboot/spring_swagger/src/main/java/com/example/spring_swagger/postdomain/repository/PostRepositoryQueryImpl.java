//package com.example.spring_swagger.postdomain.repository;
//
//import com.example.spring_swagger.postdomain.domain.DynamicSearchCond;
//import com.example.spring_swagger.postdomain.domain.Post;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import jakarta.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
//import static com.example.spring_swagger.postdomain.domain.QPost.post;
//
//@Repository
//public class PostRepositoryQueryImpl implements PostRepositoryQuery {
//    private final EntityManager em;
//    private final JPAQueryFactory queryFactory;
//
//    public PostRepositoryQueryImpl(EntityManager em) {
//        this.em = em;
//        this.queryFactory = new JPAQueryFactory(em);
//    }
//
////    @Override
////    public List<Post> getAllPostWithLikesAndWriter(DynamicSearchCond searchCond) {
////        List<Post> fetch =
////                queryFactory.select(new QPostDto(
////                    post.postId,
////                    post.title,
////                    post.body,
////                    post.likes,
////                    post.writer.userId
////                    ))
////                .from(post)
////                .where(
////                        likesGoe(searchCond.getLikes()),
////                        writerEq(searchCond.getUserName())
////                )
////                .fetch();
////
////        return fetch;
////    }
//
////    private BooleanExpression likesGoe(Integer likes) {
////        return (likes != null) ? post.likes.goe(likes) : null;
////    }
////
////    private BooleanExpression writerEq(String userId) {
////        return (StringUtils.hasText(userId)) ? post.writer.userName.eq(userId) : null;
////    }
//}
