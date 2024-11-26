import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';

const BASIC_URL = 'http://localhost:8080/';

@Injectable({
  providedIn: 'root'
})

export class CommentService {

  constructor(private http : HttpClient) { }

  createComment(postId: number, postedBy: string, content: string): Observable<any> {
    const params = { postId: postId.toString(), postedBy };
    return this.http.post<any>(`${BASIC_URL}api/comments/create`, content, { params });
  }
  

  getAllCommentByPost(postId: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(BASIC_URL + `api/comments/${postId}`).pipe(
      catchError(error => {
        console.error('Error fetching comments:', error);
        return of([]);
      })
    );
  }
  

}
